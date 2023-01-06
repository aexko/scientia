from django.contrib import admin

# Register your models here.
from app_one.models import Album, Song

admin.site.register(Album)
admin.site.register(Song)
