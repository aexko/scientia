from django.urls import path, include
from django.contrib.admin import site

urlpatterns = [
    path("admin/", site.urls),
    path("", include("snippets.urls")),
]
urlpatterns += [
    path("api-auth/", include("rest_framework.urls")),
]
