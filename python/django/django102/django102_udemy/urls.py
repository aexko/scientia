from django.contrib import admin
from django.urls import path, include

from app_one import views as app_one_views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('hello/', app_one_views.hello),
    path('app_two/', include('app_two.urls')),
    path('peoplebook/', include('peoplebook.urls')),
    path('songs/', app_one_views.song_list),
    path('songs/add/<str:song_name>/<int:duration>/', app_one_views.songs_add)
]
