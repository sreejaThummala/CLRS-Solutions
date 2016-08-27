```java
class Demo{

private Collaborator collaborator;

public Colloborator getCollaborator(){

  if(colloborator == null){
    synchronized(this){
      if(colloborator == null) return collaborator = new Collaborator();
    
    }
  }
}

}
```
What we are doing is first checking if the collaborator reference is null. If it is, we try to gain a lock on the Demo object instance (this). Once we hold the object lock, we need to check again if collaborator is still null. This double check is required because it is quite possible that between the time of the first check and the time we get the object lock, a different thread could come in, gain the lock and go ahead and construct a collaborator. So our second check is a defence against that. If we find that the collaborator is still null, we go ahead and construct one.

##what happens in times of instruction re-ordering?
###Solution
```java
private volatile Collaborator collaborator;
```
make the variable volatile 

* volatile reads are same as normal reads
* volatile writes on other hand are expensive

###Solution
```java


class Demo {

    private volatile Collaborator collaborator;

    public Collaborator getCollaborator() {
        Collaborator tmp = collaborator;
        if (tmp == null) {
            synchronized(this) {
                tmp = collaborator;
                if (tmp == null) {
                    tmp = new Collaborator();
                    collaborator = tmp;
                }
            }
        }
        return tmp;
    }
}
```
*keep tmp variable to write


