from django.http import HttpResponse

from django.template import loader


# Create your views here.
def djangorocks(request):
    return HttpResponse('This is a Jazzy Reponse')


def pictures_detail(request, category, year=0, month=0, day=0):
    template = loader.get_template('app_two/index.html')

    context = {
        'pictures': [
            {
                'name': 'Ice Skating',
                'filename': 'ice_skating.jpg',
            },
            {
                'name': 'Goose',
                'filename': 'goose.jpg',
            },
            {
                'name': 'FIFA',
                'filename': 'fifa.webp',
            },
        ]
    }
    return HttpResponse(template.render(context, request))
