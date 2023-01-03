
from django.urls import path

from peoplebook import views as views_peoplebook

urlpatterns = [
    path('users/', views_peoplebook.liste_utilisateur),
    path('users/<str:name>/detail/', views_peoplebook.details_utilisateur)
]
