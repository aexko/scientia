from django.shortcuts import render

# Create your views here.

# vue_app/views.py
def test_vue(request):
    return render(request, 'vue_app/test.html')