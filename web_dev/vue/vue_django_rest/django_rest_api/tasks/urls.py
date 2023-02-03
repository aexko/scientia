from django.urls import path
from . import views

# Definition des routes
urlpatterns = [
    path('tasks/', views.tasks, name='GET_ALL_tasks'),
    path('tasks/<int:pk>/', views.task_detail, name='GET_ONE_task')
]