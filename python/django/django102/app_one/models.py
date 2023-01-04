from django.db import models


# Create your models here.
class Song(models.Model):
    # pas besoin de faire ca puisque django le fait automatiquement
    # id = models.AutoField
    name = models.CharField(max_length=255, default='No name')
    duration = models.IntegerField(default=0, help_text='Duration in seconds')
    lyrics = models.TextField(blank=True)

    # definir ca pour que ca soit plus representatif au lieu d'une simple adresse qui veut rien dire
    # pk est le id, on peut utiliser id, mais il vaut mieux utiliser pk
    def __str__(self):
        return self.pk

