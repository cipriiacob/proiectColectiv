import React, { Component } from 'react';
import AuthService from '../services/AuthService';

export default class Login extends Component {
  constructor() {
    super();
    this.state = {
      user: '',
      password: ''
    };
  }

  login(e) {
    e.preventDefault();
    AuthService.login(this.state.user, this.state.password);
  }

  render() {
    return (
        <form role="form">
        <div className="form-group">
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
      </form>
    );
  }

  onChangeUser(e) {
    this.setState({ user: e.target.value });
  }

  onChangePassword(e) {
    this.setState({ password: e.target.value });
  }
}
