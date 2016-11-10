import React, { Component } from 'react';
import Login from './login';
import User from './user';
import '../../style/App.css';

class App extends Component {
  render() {
    return (
      <div>
      {!localStorage.getItem('id') ? (
        <Login />
      ) : (
        <User />
      )}
      </div>
    );
  }
}

export default App;
