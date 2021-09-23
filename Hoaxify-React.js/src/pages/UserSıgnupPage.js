import React from 'react';
import {signup} from '../services/apiCalls';
export class UserSignupPage extends React.Component{
    state ={
      username : null,
      displayName:null,
      password:null,
      passwordConfirm:null,
      pendingApiCall:false,
      errors:{}
    
    };
    onChange = event =>{
        const {name,value} = event.target;
        const errors= {...this.state.errors}
        errors[name] = undefined;
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
        const {username} = errors;
        return (
            <div className="container">
            <form>
                <h1>Sign Up</h1>
                <div className="mb-3">
                    <label>Username</label>
                    <input className={username ? "form-control is-invalid": "form-control"} name="username" onChange={this.onChange} />
                    <div class="invalid-feedback">
                       {username}
                   </div>
                </div>
                <div className="mb-3">  
                    <label>Display name</label>
                    <input className="form-control" name="displayName" onChange={this.onChange}/>
                </div>
                <div className="mb-3">
                <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
                    <input className="form-control"   name="password" type="password" id="exampleInputPassword1" onChange={this.onChange}/>
                </div>
                <div className="mb-3">
                <label for="exampleInputPassword1" class="form-label">Confirm Password</label>
                    <input className="form-control"  name="passwordConfirm" type="password" onChange={this.onChange}/>
                </div>

                <div className="text-center ">
                <button 
                type="submit" 
                className="btn btn-primary "
                disabled={pendingApiCall}
                 onClick ={this.onClickSignUp}> {pendingApiCall ? <span className="spinner-border spinner-border-sm" role="status" ></span>:''}Sign up</button>
                </div>
            </form>

            </div>
        );
    }
}