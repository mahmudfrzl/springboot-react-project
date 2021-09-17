import React from 'react';
export class UserSignupPage extends React.Component{
    state ={
      username : null,
      displayName:null,
      password:null,
      passwordConfirm:null,
      agreedClicked :false
    };
    onChange = event =>{
        const {name,value} = event.target;
        this.setState({
            [name] :value
        });
    }
    onChangeAgree = event =>{
        this.setState({
            agreedClicked : event.target.checked
        });
    }

    render(){
        return (
            
            <form>
                <h1>Sign Up</h1>
                <div>
                    <label>Username</label>
                    <input name="username" onChange={this.onChange} />
                </div>
                <div>
                    <label>Display name</label>
                    <input name="displayName" onChange={this.onChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input name="password" type="password" onChange={this.onChange}/>
                </div>
                <div>
                <label>Confirm Password</label>
                    <input name="passwordConfirm" type="password" onChange={this.onChange}/>
                </div>
                <input type="checkbox" onChange={this.onChangeAgree} />Agreed
                <button disabled={!this.state.agreedClicked} > Sign up</button>
            </form>
        );
    }
}