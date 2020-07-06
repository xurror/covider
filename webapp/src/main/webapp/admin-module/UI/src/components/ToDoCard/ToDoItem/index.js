<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';
import Checkbox from '@material-ui/core/Checkbox';


const ToDoItem = ({todo, onTodoChecked}) => {

  return (
    <div className="todo-cell d-flex">

      <Checkbox color="primary"
                checked={todo.selected}
                onClick={(event) => {
                  event.stopPropagation();
                  onTodoChecked(todo);
                }}
                value="SelectTodo"
                className="size-30 mr-2"
      />

      <span className={`align-self-center wra ${todo.selected && 'text-muted text-strikethrough'}`}>
                 {todo.notes}
            </span>

    </div>

  )
};

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';
import Checkbox from '@material-ui/core/Checkbox';


const ToDoItem = ({todo, onTodoChecked}) => {

  return (
    <div className="todo-cell d-flex">

      <Checkbox color="primary"
                checked={todo.selected}
                onClick={(event) => {
                  event.stopPropagation();
                  onTodoChecked(todo);
                }}
                value="SelectTodo"
                className="size-30 mr-2"
      />

      <span className={`align-self-center wra ${todo.selected && 'text-muted text-strikethrough'}`}>
                 {todo.notes}
            </span>

    </div>

  )
};

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default ToDoItem;