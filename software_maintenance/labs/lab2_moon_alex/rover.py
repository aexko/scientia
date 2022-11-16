from random import uniform
from time import sleep

from moon import Moon
from ground import Ground
from ground import GroundMineral
from ground import GroundStyle


class Rover:

    def __init__(self) -> None:

        self.__position = [0, 0]
        self.__analysis_ready = False
        self.__analyzing = False

    def analyze(self) -> None:
        """Analyse le sol"""
        self.__analyzing = True
        sleep(uniform(0.1, 0.1)) # TEMPS
        self.__analyzing = False
        self.__analysis_ready = True

    def get_analysis_results(self, ground: Ground) -> dict:
        """Retourne les niveaux de minéraux détectés par l'analyse."""
        if self.__analysis_ready:
            self.__analysis_ready = False
            return {GroundMineral.IRON: ground.get_mineral_level(GroundMineral.IRON),
                    GroundMineral.COPPER: ground.get_mineral_level(GroundMineral.COPPER),
                    GroundMineral.CARBON: ground.get_mineral_level(GroundMineral.CARBON),
                    GroundMineral.TITANIUM: ground.get_mineral_level(GroundMineral.TITANIUM),
                    GroundMineral.POTASSIUM: ground.get_mineral_level(GroundMineral.POTASSIUM),
                    GroundMineral.MAGNESIUM: ground.get_mineral_level(GroundMineral.MAGNESIUM),
                    GroundMineral.SODIUM: ground.get_mineral_level(GroundMineral.SODIUM),
                    GroundMineral.UNKNOWN: ground.get_mineral_level(GroundMineral.UNKNOWN),
                    GroundMineral.VIBRANIUM: ground.get_mineral_level(GroundMineral.VIBRANIUM)}
        else:
            return {}


    
    
    def move_east(self, moon: Moon) -> None:
        """Déplace le rover vers l'Est."""
        x = self.position[0]
        if moon.get(self.position[0] + 1, self.position[1]).style != GroundStyle.OBSTACLE:
            self.position = [x + 1, self.position[1]]
        print("MOVE EAST X ", x)

    def move_north(self, moon: Moon) -> None:
        """Déplace le rover vers le Nord."""
        y = self.position[1]
        if moon.get(self.position[0], self.position[1] + 1).style != GroundStyle.OBSTACLE:
            self.position = [self.position[0], y + 1]
            
        print("MOVE NORTH Y ", y)


    def move_south(self, moon: Moon) -> None:
        """Déplace le rover vers le Sud."""
        y = self.position[1]
        if moon.get(self.position[0], self.position[1] - 1).style != GroundStyle.OBSTACLE:
            self.position = [self.position[0], y - 1]
        print("MOVE SOUTH Y ", y)


    def move_west(self, moon: Moon) -> None:
        """Déplace le rover vers l'Ouest'."""
        x = self.position[0]
        if moon.get(self.position[0] - 1, self.position[1]).style != GroundStyle.OBSTACLE:
            self.position = [x - 1, self.position[1]]
        print("MOVE WEST X ", x)

    @property
    def analyzing(self) -> bool:
        return self.__analyzing

    @property
    def position(self) -> tuple:
        return tuple(self.__position)

    @position.setter
    def position(self, pos: tuple) -> None:
        self.__position = list(pos)
