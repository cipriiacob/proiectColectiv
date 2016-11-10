import React, { Component } from 'react';
import Login from './login';

export default class User extends Component {
  constructor() {
    super();
    this.state = {};
  }

  logout() {
    localStorage.removeItem('id');
  }


  render() {
    return (
      <div>
      {!localStorage.getItem('id')=== null ? (
        <Login />
      ) : (
        <div>
          <p className='message'>Welcome to users page</p>
          <a className='logout' href='/' onClick={this.logout.bind(this)}>Logout</a>
        </div>
      )}
      </div>
    );
  }

}
