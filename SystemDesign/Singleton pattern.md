```java
class Demo {

    private static class CollaboratorHolder {
        public static final Collaborator collaborator = new Collaborator();
    }

    public Collaborator getCollaborator() {
        return CollaboratorHolder.collaborator;
    }
}
```
* JLS guarantees an inner class will not be initialized until it is referenced elsewhere
