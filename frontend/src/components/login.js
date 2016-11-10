import React, { Component } from 'react';
import AuthService from '../services/AuthService';
import User from './user';
import '../../style/login.css'

export default class Login extends Component {
  constructor() {
    super();
    this.state = {
      user:       '',
      password:   '',
      error_msg:  '',
    };
  }

  login(e) {
    e.preventDefault();
    let logged_in = AuthService.login(this.state.user, this.state.password);
    if(!logged_in) {
      this.setState({error_msg: 'Wrong username or password, try again...'});
    }
    else {
      this.setState({error_msg: ''});
    }
  }

  render() {
    return (
      <div>
        {localStorage.getItem('id') ? (
          <User />
        ) : (
          <form role="form">
            <div className="form-group">
            {localStorage.getItem('id')}
              <input type="text"
                placeholder="Username"
                value={this.state.user}
                onChange={this.onChangeUser.bind(this)} />
              <input type="password"
                placeholder="Password"
                value={this.state.password}
                onChange={this.onChangePassword.bind(this)} />
            </div>
            <button type="submit" onClick={this.login.bind(this)}>Submit</button>
            <div className='error'>{this.state.error_msg}</div>
          </form>
        )}
      </div>
    );
  }

  onChangeUser(e) {
    this.setState({ user: e.target.value });
  }

  onChangePassword(e) {
    this.setState({ password: e.target.value });
  }
}
