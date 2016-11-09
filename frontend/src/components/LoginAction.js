// import RouterContainer from '../route';
import React from 'react';
import ReactDOM from 'react-dom';
export default {
  loginUser: (id, username) => {
    const element = <h1 id='home'>Hello, {username}</h1>;
    ReactDOM.render(
      element,
      document.getElementById('root')
    );
    localStorage.setItem('id', id);
  }
}
