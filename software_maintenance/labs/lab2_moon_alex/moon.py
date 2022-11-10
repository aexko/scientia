from random import randint


from ground import GroundStyle
from ground import Ground


class Moon:

    __MOON_WIDTH = __MOON_HEIGHT = 50

    def __init__(self) -> None:
        self.__grid = [[Ground(self.__random_style()) for _ in range(self.__MOON_HEIGHT)]
                       for _ in range(self.__MOON_WIDTH)]

        # Place des obstacles sur le contour
        for i in range(self.__MOON_WIDTH):
            self.__grid[0][i].style = self.__grid[self.__MOON_WIDTH - 1][i].style = GroundStyle.OBSTACLE
            self.__grid[i][0].style = self.__grid[i][self.__MOON_WIDTH - 1].style = GroundStyle.OBSTACLE

        self.__update_me = True

    @staticmethod
    def __random_style() -> GroundStyle:
        """Crée un type de sol aléatoirement (poussière 19 fois sur 20, sinon obstacle)."""

        if randint(0, 20) == 19:
            return GroundStyle.OBSTACLE

        return GroundStyle.DIRT

    def get(self, x, y: int) -> Ground:
        return self.__grid[x][y]

    def height(self) -> int:
        return self.__MOON_HEIGHT

    def width(self) -> int:
        return self.__MOON_WIDTH

    @property
    def update_me(self) -> bool:
        return self.__update_me
