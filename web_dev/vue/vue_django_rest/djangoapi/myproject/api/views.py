from rest_framework.response import Response
from rest_framework.decorators import api_view
from core.models import Item
from .serializers import ItemSerializer

# GET ALL ITEMS
@api_view(["GET"])
def itemList(request):
    items = Item.objects.all()
    serializer = ItemSerializer(
        items, many=True
    )  # if it was one item, we would not need to specify many=False
    return Response(serializer.data)  # return JSON response


# GET ONE ITEM
@api_view(["GET"])
def itemDetail(request, pk):
    items = Item.objects.get(id=pk)
    serializer = ItemSerializer(items, many=False)
    return Response(serializer.data)


# CREATE
@api_view(["POST"])
def itemCreate(request):
    serializer = ItemSerializer(
        data=request.data
    )  # request.data is the data that is being sent to the backend
    if serializer.is_valid():
        serializer.save()
    else:
        print("ERREUR")
        print(serializer.errors)
    return Response(serializer.data)  # return the data that was sent to the backend


@api_view(["POST"])
def itemUpdate(request, pk):
    item = Item.objects.get(id=pk)
    serializer = ItemSerializer(instance=item, data=request.data)

    if serializer.is_valid():
        serializer.save()
        
    return Response(serializer.data)


# DELETE
@api_view(["DELETE"])
def itemDelete(request, pk):
    item = Item.objects.get(id=pk)
    item.delete()
    return Response("Item was deleted successfully")
