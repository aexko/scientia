from django.urls import path, include
from django.contrib.admin import site
from rest_framework.authtoken import views

urlpatterns = [
    path("admin/", site.urls),
    path("", include("snippets.urls")),
    path('api-token-auth/', views.obtain_auth_token, name='api-token-auth'),

    
]
urlpatterns += [
    path("api-auth/", include("rest_framework.urls", namespace="rest_framework"))
]
