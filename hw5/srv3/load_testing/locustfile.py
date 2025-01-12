from locust import HttpUser, task

class HelloWorldUser(HttpUser):
    @task
    def hello_world(self):
        self.client.get("/user/1")
        # self.client.get("/user/2")

# GET http://srv2.lovaldev.me:8000/user/1
# GET http://srv2.lovaldev.me:8000/user/2
# GET http://srv2.lovaldev.me:8000/user/3
# GET http://srv2.lovaldev.me:8000/user/4