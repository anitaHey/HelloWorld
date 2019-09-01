from django.db import models

# Create your models here.
class User(models.Model):
    UserName = models.CharField(max_length=20,primary_key=True)
    Account = models.CharField(max_length=20)
    Password = models.CharField(max_length=20)
    Status = models.IntegerField()
    Gender = models.IntegerField()
    Email = models.CharField(max_length=30)
    PictureID = models.ForeignKey('Picture',related_name='User_Picture', null=True, blank=True, on_delete=models.SET_NULL)
    LastLoginIP = models.IntegerField()
    CreateTime = models.DateTimeField(auto_now_add=True)
    UpdateTime = models.DateTimeField(auto_now=True)

    def __str__(self):
        return "[{}] {}".format(self.id, self.UserName)

class ChatRoom(models.Model):
    RelationshipID = models.ForeignKey('Relationship', related_name='ChatRoom_Relationship', null=True, blank=True, on_delete=models.SET_NULL)
    PictureID = models.ForeignKey('Picture',related_name='ChatRoom_Picture', null=True, blank=True, on_delete=models.SET_NULL)
    CreateTime = models.DateTimeField(auto_now_add=True)
    UpdateTime = models.DateTimeField(auto_now=True)

    def __str__(self):
        return "[{}] {}".format(self.id, self.ChatRoom_Relationship.Name)
    
class Message(models.Model):
    ChatRoomID = models.ForeignKey('ChatRoom', related_name='Message_ChatRoom', null=True, blank=True, on_delete=models.SET_NULL)
    SenderID = models.ForeignKey('User', related_name='Sender', null=True, blank=True, on_delete=models.SET_NULL)
    Type = models.IntegerField()
    Content = models.TextField()
    Status = models.IntegerField()
    CreateTime = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return "[{}][{}->{}] {}".format(self.Status, self.Sender.UserName, self.Message_ChatRoom.ChatRoom_Relationship.Name, self.Content)

class Relationship(models.Model):
    Type = models.IntegerField()
    Name = models.CharField(max_length=40)
    Number = models.IntegerField()
    PictureID = models.ForeignKey('Picture', related_name='Relationship_Picture', null=True, blank=True, on_delete=models.SET_NULL)
    CreateTime = models.DateTimeField(auto_now_add=True)
    UpdateTime = models.DateTimeField(auto_now=True)

    def __str__(self):
        return "[{}] {} : {}".format(self.id, self.Type, self.Name)

class Relationship_Personal(models.Model):
    RelationshipID = models.ForeignKey('Relationship', related_name='Personal_Relationship', null=True, blank=True, on_delete=models.SET_NULL)
    User1ID = models.ForeignKey('User', related_name='User1', null=True, blank=True, on_delete=models.SET_NULL)
    user2ID = models.ForeignKey('User', related_name='User2', null=True, blank=True, on_delete=models.SET_NULL)
    User1_Relationship_User2 = models.CharField(max_length=40)
    User2_Relationship_USer1 = models.CharField(max_length=40)
    User1_Name_User2 = models.CharField(max_length=40)
    User2_Name_User2 = models.CharField(max_length=40)
    User1_Check = models.IntegerField()
    User2_Check = models.IntegerField()
    CreateTime = models.DateTimeField(auto_now_add=True)
    UpdateTime = models.DateTimeField(auto_now=True)

    def __str__(self):
        return "[{}] {} - {}".format(self.Personal_Relationship.id, self.User1.UserName, self.User2.UserName)

class Relationship_Group(models.Model):
    RelationshipID = models.ForeignKey('Relationship', related_name='Group_Relationship', null=True, blank=True, on_delete=models.SET_NULL)
    UserID =  models.ForeignKey('User',related_name='Group_User', null=True, blank=True, on_delete=models.SET_NULL)
    CreateTime = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return "[{}] {} - {}".format(self.Relationship.id, self.Group_Relationship.Name, self.Group_User.UserName)

class Picture(models.Model):
    Type = models.CharField(max_length=20)
    FileName = models.CharField(max_length=256, null=True, blank=True)
    Url = models.URLField()

    def __str__(self):
        return "[{}] {}".format(self.id, self.FileName)
