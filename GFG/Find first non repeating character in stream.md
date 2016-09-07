#Question
Given a stream of characters, find the first non repeating character

```java
public static char findFirstNonRepeatedChar(char input)
{
    if(hash.containsKey(Character.valueOf(input)))
    {
      DoublyNode<Character> node = hash.get(Character.valueOf(input));
      list.remove(node);
    }
    else
    {
      DoublyNode<Character> node = list.insert(input);
      hash.put(Character.valueOf(input), node);
    }
    
    return list.head.data;
}
