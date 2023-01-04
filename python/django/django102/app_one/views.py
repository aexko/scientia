from django.shortcuts import render
from django.http import HttpResponse
from app_one.models import Song


# Create your views here.

def hello(request):
    return HttpResponse('App One')


def song_list(request):
    names = []
    for s in Song.objects.all():
        names.append(s.name)
    body = '<br/>'.join(names)
    return HttpResponse(body)


def songs_add(request, song_name, duration):
    song = Song(name=song_name, duration=duration)
    song.save()
    return HttpResponse("Song saved at id={}".format(song.pk))
