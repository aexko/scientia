from django.shortcuts import render
from django.http import HttpResponse


# Create your views here.
def djangorocks(request):
    return HttpResponse('This is a Jazzy Reponse')


def pictures_detail(request, category, year=0, month=0, day=0):
    body = "Category={}, year={}, month={}, day={}".format(category, year, month, day)
    return HttpResponse(body)
