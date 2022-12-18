from django.shortcuts import render
from django.http import HttpResponse

from django.template import loader


# Create your views here.
def djangorocks(request):
    return HttpResponse('This is a Jazzy Reponse')


def pictures_detail(request, category, year=0, month=0, day=0):
    template = loader.get_template('app_two/index.html')

    picture = {
        'filename': 'moi.png',
        'categories': ['color', 'landscape', 'art', 'music', 'ice skating'],
    }

    context = {
        'title': 'TITLEEEE WOeweowerowerw we asodkoikwoiq qwoi',
        'category': category,
        'description': 'This <b>picture</b> was taken in Montreal',
        'year': year,
        'month': month,
        'day': day,
        'picture': picture,
    }
    return HttpResponse(template.render(context, request))


