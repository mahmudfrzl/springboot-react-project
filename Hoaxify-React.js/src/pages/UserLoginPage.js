import React from "react";
import Input from "../components/Input";
import { withTranslation } from 'react-i18next';
import {login} from '../services/apiCalls'
class UserLoginPage extends React.Component {
  state = {
    username: null,
    password: null,
  };
  onChange = (event) => {
    const { name, value } = event.target;
    this.setState({
      [name]: value,
    });
  };

  onClickLogin = (event) =>{
      event.preventDefault();
      const {username,password} = this.state
      const creds = {
          username,
          password
      };
      login(creds);
  };

  render() {
        const {t} = this.props

    return (
      <div className="container">
        <form>
          <h1 className="text-center">{t('Login')}</h1>
          <Input label={t('Username')} name="username" />
          <Input type = "password" label={t('Password')} name="password" />
          <div className="text-center">
            <button onClick ={this.onClickLogin} className="btn btn-primary">{t('Login')}</button>
          </div>
        </form>
      </div>
    );
  }
}

const UserLoginPageWithTranslation = withTranslation()(UserLoginPage)
export default UserLoginPageWithTranslation;
