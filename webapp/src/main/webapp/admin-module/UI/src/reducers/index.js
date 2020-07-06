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
