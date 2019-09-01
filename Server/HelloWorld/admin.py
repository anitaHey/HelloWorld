from django.contrib import admin
from .models import *

# Register your models here.
admin.site.register(User)
admin.site.register(ChatRoom)
admin.site.register(Message)
admin.site.register(Relationship)
admin.site.register(Relationship_Personal)
admin.site.register(Relationship_Group)
admin.site.register(Picture)
