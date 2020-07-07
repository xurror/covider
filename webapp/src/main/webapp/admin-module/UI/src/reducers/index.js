<<<<<<< HEAD
<<<<<<< HEAD
import {combineReducers} from 'redux';
import {connectRouter} from 'connected-react-router'
import Settings from './Settings';
import ToDo from './ToDo';
import Auth from './Auth';


export default (history) => combineReducers({
  router: connectRouter(history),
  settings: Settings,
  toDo: ToDo,
  auth: Auth,
});
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import {combineReducers} from 'redux';
import {connectRouter} from 'connected-react-router'
import Settings from './Settings';
import ToDo from './ToDo';
import Auth from './Auth';


export default (history) => combineReducers({
  router: connectRouter(history),
  settings: Settings,
  toDo: ToDo,
  auth: Auth,
});
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
