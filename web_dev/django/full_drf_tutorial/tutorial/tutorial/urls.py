from django.urls import path, include
from django.contrib.admin import site
from rest_framework.authtoken import views as auth_views

from snippets import views

urlpatterns = [
    path("admin/", site.urls),
    path("", include("snippets.urls")),
    path('api-token-auth/', auth_views.obtain_auth_token, name='api-token-auth'),
    path('api-get-csrf/', views.get_csrf_token, name='api-cors-token-auth'),
    path('login/', views.LoginView.as_view()),
    
]
urlpatterns += [
    path("api-auth/", include("rest_framework.urls", namespace="rest_framework"))
]
