import LoginActions from '../components/LoginAction';
var users = [
  {
    id: '1',
    username: 'boss',
    password: 'boss'
  },
  {
    id: '2',
    username: 'dev',
    password: 'dev'
  }
];

class AuthService {
  login(username, password) {
    var index = null;
    for(var i = 0; i < users.length; i++) {
        if(users[i]['username'] === username && users[i]['password'] === password) {
            index = i;
        }
    }
    if (index !== null) {
      LoginActions.loginUser(users[index]['id'], users[index]['username']);
    }
    else {
      return false;
    }
    return true;
  }
}

export default new AuthService();
