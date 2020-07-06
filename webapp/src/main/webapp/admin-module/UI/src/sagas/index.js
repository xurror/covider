<<<<<<< HEAD
import {all} from 'redux-saga/effects';
import toDoSagas from './Todo';
import authSagas from './Auth';

export default function* rootSaga(getState) {
  yield all([
    toDoSagas(),
    authSagas()
  ]);
}
=======
import {all} from 'redux-saga/effects';
import toDoSagas from './Todo';
import authSagas from './Auth';

export default function* rootSaga(getState) {
  yield all([
    toDoSagas(),
    authSagas()
  ]);
}
>>>>>>> 4d2bbb9... backbone for the dashboard
