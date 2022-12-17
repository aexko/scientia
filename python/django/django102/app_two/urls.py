
from django.urls import path
from django.urls import register_converter

from app_two import views as app_two_views

from app_two import converters
register_converter(converters.TwoDigitDayConverter, 'dd')

urlpatterns = [
    path('djangorocks/', app_two_views.djangorocks),
    path('pictures/<str:category>/', app_two_views.pictures_detail),
    path('pictures/<str:category>/<int:year>/<int:month>/', app_two_views.pictures_detail),
    path('pictures/<str:category>/<int:year>/<int:month>/<dd:day>/', app_two_views.pictures_detail),

]
