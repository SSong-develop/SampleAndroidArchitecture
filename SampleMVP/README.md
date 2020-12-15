MVP comes into the picture as an alternativie to the tranditional MVC architecture pattern.

Using MVC as the software architecture, developers end up with the following difficulties

1. Most of the core business logic resides in Controller. During the lifetime of an application, this file grows bigger and it becomes difficult to maintain the code

2. Because of tightly-coupled UI and data access mechanisms, both Controller and View layer falls in the same activity or fragment. This cause problem in making changes in the features of the application

3. it becomes hard to carry out Unit testing of the different layer as most of the part which are under testing needs Android SDK components

   ![img](https://media.geeksforgeeks.org/wp-content/uploads/20201024233154/MVPSchema.png)

**Model** : Layer for storing data. it is responsible for handling the domain logic and communication with the database and network layers

- **데이터를 저장하는 layer . 사용자에게 보여져야할 로직에 대해 처리해야하는 책임 , 데이터베이스와 네트워크 layer와 통신**

**View** : UI layer. it provides the visualization of the data and keep a track of the user's action in order to notify the Presenter

- **UI layer. 데이터를 보여주고 사용자의 활동을 관찰하고 presenter에게 알려준다.** 

**Presenter** : Fetch the data from the model and applies the UI logic to decide what to display. it manages the state of the View and takes actions according to the user's input notification from the View

- **Model의 데이터를 fetch , UI logic에 적용한다. 이후 어떤 것을 보여줄지를 결정한다. 유저가 View에게 알려주거나 or input이 있을 때 View의 상태와 action을 관리한다.**



