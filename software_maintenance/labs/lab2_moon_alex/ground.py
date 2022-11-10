from enum import Enum
from enum import auto

from random import uniform


from settings import *


class GroundStyle(Enum):
    DIRT = auto(),
    OBSTACLE = auto()


class GroundMineral(Enum):
    """Énumération des minéraux qui peuvent être détectés par analyse du sol."""
    IRON = auto(),
    COPPER = auto(),
    CARBON = auto(),
    TITANIUM = auto(),
    POTASSIUM = auto(),
    MAGNESIUM = auto(),
    CALCIUM = auto(),
    SODIUM = auto(),
    UNKNOWN = auto(),
    # ajout du minerai vibranium
    VIBRANIUM = auto(),


class Ground:
    """Parcelle de sol lunaire."""

    def __init__(self, style: GroundStyle) -> None:
        self.style = style
        self.__analyzed = False

        self.__soil = {}
        for mineral in GroundMineral:
            self.__soil[mineral] = round(uniform(0.0, 100.0), 2)

        self.__predominant_mineral = None

    def get_mineral_level(self, mineral: GroundMineral) -> float:
        """Retourne le niveau d'un minéral donné dans le sol."""
        return self.__soil[mineral]

    @staticmethod
    def get_mineral_color(mineral: GroundMineral) -> tuple:
        """Retourne la couleur associée à un minéral."""
        if mineral == GroundMineral.IRON:
            return COLOR_IRON
        if mineral == GroundMineral.COPPER:
            return COLOR_COPPER
        if mineral == GroundMineral.CARBON:
            return COLOR_CARBON
        if mineral == GroundMineral.TITANIUM:
            return COLOR_TITANIUM
        if mineral == GroundMineral.POTASSIUM:
            return COLOR_POTASSIUM
        if mineral == GroundMineral.MAGNESIUM:
            return COLOR_MAGNESIUM
        if mineral == GroundMineral.CALCIUM:
            return COLOR_CALCIUM
        if mineral == GroundMineral.SODIUM:
            return COLOR_SODIUM
        # ajout du minerai vibranium
        if mineral == GroundMineral.VIBRANIUM:
            return COLOR_VIBRANIUM
        return COLOR_UNKNOWN

    @property
    def predominant_mineral(self) -> GroundMineral:
        return self.__predominant_mineral

    @property
    def style(self) -> GroundStyle:
        return self.__style

    @predominant_mineral.setter
    def predominant_mineral(self, mineral) -> None:
        self.__predominant_mineral = mineral

    @style.setter
    def style(self, style: GroundStyle) -> None:
        self.__style = style
