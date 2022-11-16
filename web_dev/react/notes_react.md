# ReactJS

## what is a React component?
this is an example of a React component class, also called React component type:

```
class ShoppingList extends React.Component {
  render() {
    return (
      <div className="shopping-list">
        <h1>Shopping List for {this.props.name}</h1>
        <ul>
          <li>Instagram</li>
          <li>WhatsApp</li>
          <li>Oculus</li>
        </ul>
      </div>
    );
  }
}

// Example usage: <ShoppingList name="Mark" />`
```
## what are the parameters that the component save are called?
they're called props which is property for short

## what does a component return?
a hierarchy of views to display via the render method

## what is the render method?
- it returns what the user sees on screen
- it returns a 
