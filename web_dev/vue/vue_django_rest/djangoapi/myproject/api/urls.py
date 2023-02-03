from django.urls import path
from . import views

urlpatterns = [
    path("item-list", views.itemList, name="get-data"),
    path("item-detail/<str:pk>/", views.itemDetail, name="get-item"),

    path("item-create/", views.itemCreate, name="add-item"),
    path("item-update/<str:pk>/", views.itemUpdate, name="update-item"),
    
    path("item-delete/<str:pk>/", views.itemDelete, name="delete-item"),
]
