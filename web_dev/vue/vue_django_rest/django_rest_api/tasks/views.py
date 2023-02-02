from django.shortcuts import render

# pour parser les donnees du client
from rest_framework.parsers import JSONParser

# pour contourner CSRF token
from django.views.decorators.csrf import csrf_exempt

# pour repondre au client
from django.http import HttpResponse, JsonResponse

# Definition de l'API pour les Tasks
from .serializers import TaskSerializer

# Model Task
from .models import Task

@csrf_exempt
def tasks(request):
    '''
    Listes des tasks snippets
    '''
    if (request.method == 'GET'):
        # get tous les tasks
        tasks = Task.objects.all()
        
        # serialiser les donnees des tasks
        serializer = TaskSerializer(tasks, many=True)
        
        # retourne une reponse JSON
        return JsonResponse(serializer.data, safe=False)
    elif(request.method == 'POST'):
        # parse les donnees arrivantes
        data = JSONParser().parse(request)
        
        # cree une instance avec le seraializer
        serializer = TaskSerializer(data=data)
        
        # verifie si les donnees sont valides
        if (serializer.is_valid()):
            # si c'est valid, il sauvegarde les donnees
            serializer.save()
            
            # retourne une reponse json avec les donnees sauvegardees
            return JsonResponse(serializer.data, status=201)
        
        # sinon retourne une erreur 404 avec les erreurs
        return JsonResponse(serializer.errors, status=400)