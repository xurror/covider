<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';

import ToDoItem from "./ToDoItem/index";

class SimpleToDo extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      allToDos: props.data,
      toDos: props.data
    }
  }

  onTodoChecked(data) {
    data.selected = !data.selected;
    const toDos = this.state.toDos.map(todo => (todo.id === data.id) ? data : todo);
    this.setState({
      toDos: toDos
    });
  }

  render() {
    const {toDos} = this.state;
    return (
      <div className="todo-cell-group">
        {toDos.map((todo, index) =>
          <ToDoItem key={index} index={index} todo={todo}
                    onTodoChecked={this.onTodoChecked.bind(this)}/>
        )}
      </div>
    )
  }
}

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';

import ToDoItem from "./ToDoItem/index";

class SimpleToDo extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      allToDos: props.data,
      toDos: props.data
    }
  }

  onTodoChecked(data) {
    data.selected = !data.selected;
    const toDos = this.state.toDos.map(todo => (todo.id === data.id) ? data : todo);
    this.setState({
      toDos: toDos
    });
  }

  render() {
    const {toDos} = this.state;
    return (
      <div className="todo-cell-group">
        {toDos.map((todo, index) =>
          <ToDoItem key={index} index={index} todo={todo}
                    onTodoChecked={this.onTodoChecked.bind(this)}/>
        )}
      </div>
    )
  }
}

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default SimpleToDo;