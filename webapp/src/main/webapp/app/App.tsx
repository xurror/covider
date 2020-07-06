import React from 'react';
import './App.css';
import Home from './registration-module/Home/Home';
import { createStore, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import thunk from 'redux-thunk';
import reducers from './registration-module/redux/reducers/index'

const store = createStore(reducers, applyMiddleware(thunk));

function App() {
  return (
    <Provider store={store}>
      <Home />
      </Provider>
  );
}

export default App;
