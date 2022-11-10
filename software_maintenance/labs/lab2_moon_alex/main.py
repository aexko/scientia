import arcade
import threading


from random import randint
from time import sleep

from settings import *

from rover import Rover
from ground import Ground
from ground import GroundMineral
from ground import GroundStyle
from moon import Moon


class AnalyzeThread(threading.Thread):

    def __init__(self, rover: Rover) -> None:
        super().__init__()

        self.__rover = rover
        self.__position = rover.position

        self.__callback = None
        self.__analyze = False
        self.__running = False

    def run(self) -> None:
        self.__running = True

        while self.__running:
            if self.__analyze:
                self.__position = self.__rover.position
                self.__rover.analyze()
                self.__analyze = False
                self.__callback(self.__position)
            else:
                sleep(0.05)

    def stop(self) -> None:
        self.__running = False

    def analyze(self, callback) -> None:
        self.__analyze = True
        self.__callback = callback


class Mission2Moon(arcade.Window):

    def __init__(self, width: int = SCREEN_WIDTH, height: int = SCREEN_HEIGHT, title: str = SCREEN_TITLE):
        super().__init__(width, height, title)

        arcade.set_background_color(arcade.color.BLACK)

        self.__tile_shapes = []
        self.__tiles = arcade.ShapeElementList()

        self.__time_since_last_move = 0.0
        self.__moving_east = self.__moving_west = self.__moving_north = self.__moving_south = False

        self.__analyze = False
        self.__time_since_last_blink = 0.0
        self.__show_rover = True

        self.__moon = Moon()
        self.__rover = Rover()
        self.__rover2 = Rover()

        self.__analysis_results_ready = False
        self.__analysis_results_position = (0, 0)
        self.__analyze_thread = AnalyzeThread(self.__rover)
        self.__analyze_thread.start()
        # intialisation de toutes les variables

    def on_draw(self) -> None:
        """Dessine l'écran sur une base régulière."""

        arcade.start_render()

        self.__tiles.draw()

        if self.__show_rover:
            arcade.draw_rectangle_filled(5 + self.__rover.position[0] * 10,
                                         5 + self.__rover.position[1] * 10, 8, 8, (255, 192, 0))

    def on_key_press(self, symbol: int, modifiers: int):
        if symbol == arcade.key.UP:
            self.__moving_north = True
        elif symbol == arcade.key.DOWN:
            self.__moving_south = True
        elif symbol == arcade.key.LEFT:
            self.__moving_west = True
        elif symbol == arcade.key.RIGHT:
            self.__moving_east = True
        elif symbol == arcade.key.SPACE:
            self.__analyze = True
            self.__analyze_thread.analyze(self.__mark_get_analysis_results)

# commandes pour controler le rover 
    def on_key_release(self, symbol: int, modifiers: int):
        if symbol == arcade.key.UP:
            self.__moving_north = False
        elif symbol == arcade.key.DOWN:
            self.__moving_south = False
        elif symbol == arcade.key.LEFT:
            self.__moving_west = False
        elif symbol == arcade.key.RIGHT:
            self.__moving_east = False

    def on_update(self, delta_time: float):

        self.__time_since_last_move += delta_time
        self.__time_since_last_blink += delta_time

        if self.__time_since_last_move >= MOVING_PACE:
            self.__time_since_last_move = 0.0
            if not self.__rover.analyzing:
                if self.__moving_north:
                    self.__rover.move_north(self.__moon)
                elif self.__moving_south:
                    self.__rover.move_south(self.__moon)
                elif self.__moving_west:
                    self.__rover.move_west(self.__moon)
                elif self.__moving_east:
                    self.__rover.move_east(self.__moon)

        if self.__time_since_last_blink >= BLINKING_PACE:
            self.__time_since_last_blink = 0.0
            self.__show_rover = not self.__show_rover

        if not self.__rover.analyzing:
            self.__show_rover = True

        if self.__analysis_results_ready:
            self.__get_analysis_results(self.__analysis_results_position)

    def build_moon(self) -> None:
        """Construit la grille visuelle représentant la lune."""

        for y in range(self.__moon.height()):
            for x in range(self.__moon.width()):
                tile = self.__moon.get(x, y)
                if tile.style == GroundStyle.DIRT:
                    shape = arcade.create_rectangle_filled(5 + x * 10, 5 + y * 10, 8, 8, (32, 32, 32))
                else:
                    shape = arcade.create_rectangle_filled(5 + x * 10, 5 + y * 10, 8, 8, (128, 128, 128))
                self.__tile_shapes.append(shape)
                self.__tiles.append(shape)

    def create_start_position(self) -> tuple:
        """Génère une position de départ (longitude, latitude)."""
        x = y = 0
        free_spot = False
        while not free_spot:
            x = randint(0, self.__moon.width() - 1)
            y = randint(0, self.__moon.height() - 1)

            if self.__moon.get(x, y).style == GroundStyle.DIRT:
                free_spot = True

        return x, y

    def set_rover_position(self, pos: tuple) -> None:
        self.__rover.position = pos

    def stop(self) -> None:
        """Arrête l'application et toutes ses composantes."""
        self.__analyze_thread.stop()
        self.__analyze_thread.join()

    def __mark_get_analysis_results(self, pos: tuple) -> None:
        """Callback pour le thread. Puisque OpenGL n'est pas thread-safe, on marque simplement."""
        self.__analysis_results_position = pos
        self.__analysis_results_ready = True

    def __get_analysis_results(self, pos: tuple) -> None:
        results = self.__rover.get_analysis_results(self.__moon.get(pos[0], pos[1]))

        highest_level = 0.0
        highest_mineral = None

        for mineral in GroundMineral:
            if mineral in results:
                if results[mineral] >= highest_level:
                    highest_level = results[mineral]
                    highest_mineral = mineral

        self.__moon.get(pos[0], pos[1]).predominant_mineral = highest_mineral

        # on modifie la liste de shape pour colorer le minéral
        color = Ground.get_mineral_color(highest_mineral)
        index = pos[1] * self.__moon.height() + pos[0]
        self.__tile_shapes[index] = arcade.create_rectangle_filled(5 + pos[0] * 10, 5 + pos[1] * 10, 8, 8, color)
        new_shape_element_list = arcade.ShapeElementList()
        for shape in self.__tile_shapes:
            new_shape_element_list.append(shape)
        self.__tiles = new_shape_element_list

        self.__analysis_results_ready = False


def main() -> None:
    """Programme principal."""

    m2m = Mission2Moon()
    m2m.build_moon()
    m2m.set_rover_position(m2m.create_start_position())

    arcade.run()
    m2m.stop()


if __name__ == '__main__':
    main()
