# because the response object cannot natively handle data types such as Django Models instances, so we need to first serialize the data before we can actually render it out

from rest_framework import serializers
from core.models import Item


class ItemSerializer(serializers.ModelSerializer):
    class Meta:
        model = Item
        fields = "__all__"
