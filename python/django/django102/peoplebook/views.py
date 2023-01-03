from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
from django.template import loader


def liste_utilisateur(request):
    return HttpResponse("Liste utilisateurs")


def details_utilisateur(request):
    template = loader.get_template('peoplebook/index.html')
    people = {
        'han': {
            'name': 'han solo',
            'job': 'millenium falcon pilot',
            'picture': 'img/han.jpg',
        },
        'harry': {
            'name': 'harry potter',
            'job': 'full-time wizard',
            'picture': 'img/harry.jpg',
        },
        'galadriel': {
            'name': 'galadriel',
            'job': 'elf queen',
            'picture': 'img/galadriel.jpg',
        },
        'wonderwoman': {
            'name': 'diana prince',
            'job': 'goddess',
            'picture': 'img/wonderwoman.jpg',
        }
    }
    return HttpResponse(people, request)
