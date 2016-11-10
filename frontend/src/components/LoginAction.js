export default {
  loginUser: (id, username) => {
    localStorage.setItem('id', id);
    console.log('local', localStorage.getItem('id'));
  }
}
