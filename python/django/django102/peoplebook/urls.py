
from django.urls import path, include

from peoplebook import views as views_peoplebook

urlpatterns = [
    path('users/', views_peoplebook.details_utilisateur),
    path('users/<str:name>/detail/', views_peoplebook.details_utilisateur)
]
