import React from 'react';
import {signup,changeLanguage} from '../services/apiCalls';
import Input from '../components/Input';
import { withTranslation } from 'react-i18next';
import LanguageSelector from '../components/LanguageSelector';
 class UserSignupPage extends React.Component{
    state ={
      username : null,
      displayName:null,
      password:null,
      passwordConfirm:null,
      pendingApiCall:false,
      errors:{}
    
    };
    onChange = event =>{
        const {t} = this.props
        const {name,value} = event.target;
        const errors= {...this.state.errors}
        errors[name] = undefined;
        if(name === 'password' || name === 'passwordConfirm'){
            if(name ==='password' && value !==this.state.passwordConfirm){
                errors.passwordConfirm = t('Password mismatch');

            }else if(name === 'passwordConfirm' && value !== this.state.password){
                errors.passwordConfirm = t('Password mismatch');
            }else{
                errors.passwordConfirm = undefined;
            }
        }
        this.setState({
            [name] :value,
            errors
        });
        
    }


    onClickSignUp = async event =>{
        event.preventDefault();
        const {username,password,displayName} = this.state;
        const body = {
            password,
            username,
            displayName
        }
        this.setState({pendingApiCall:true});

        try{
        const response = await signup(body);

        }catch(error){
            if(error.response.data.validationErrors){
                this.setState({errors:error.response.data.validationErrors});

            }
        }
        this.setState({pendingApiCall:false});

        // signup(body)
        // .then((response)=>{
        //     this.setState({pendingApiCall:false});
        // }).catch(error=>{
        //     this.setState({pendingApiCall:false});
        // })
    }


    render(){
        const {pendingApiCall,errors} = this.state
        const {username,displayName,password,passwordConfirm} = errors;
        const {t} = this.props
        return (
            <div className="container">
            <form>
                <h1 className="text-center ">{t('Sign Up')}</h1>
                <Input label={t("Username")} name="username" error={username} onChange={this.onChange}  />
                <Input label={t("DisplayName")} name="displayName" error={displayName} onChange={this.onChange}  />
                <Input label={t("Password")} name="password" error={password} onChange={this.onChange} type="password"/>
                <Input label={t("Password Confirm")} name= "passwordConfirm" error={passwordConfirm} onChange = {this.onChange} type = "password"/>

                <div className="text-center ">
                <button  
                type="submit" 
                className="btn btn-primary "            
                 onClick ={this.onClickSignUp}
                 disabled={pendingApiCall|| passwordConfirm !== undefined}> {pendingApiCall ? <span className="spinner-border spinner-border-sm" role="status" ></span>:''}{t('Sign Up')}</button>
                </div>
                {/* <div>
                    <LanguageSelector/>
                </div> */}

            </form>

            </div>
        );
    }
}

                {/* <div className="mb-3 form-group" >
                    <label>Username</label>
                    <input className={username ? "form-control is-invalid": "form-control"} name="username" onChange={this.onChange} />
                    <div className="invalid-feedback">
                       {username}
                   </div>
                </div> */}
                {/* <div className="mb-3 form-group">  
                    <label>Display name</label>
                    <input className={displayName ? "form-control is-invalid":"form-control"} name="displayName" onChange={this.onChange}/>
                    <div className="invalid-feedback">
                       {displayName}
                   </div>
                </div> */}

const UserSignUpPageWithTranslation =withTranslation()(UserSignupPage)

export default  UserSignUpPageWithTranslation;