import i18n from 'i18next'
import { initReactI18next } from 'react-i18next'

i18n.use(initReactI18next).init({
    resources:{
        en:{
            translations:{
                'Sign Up' : 'Sign Up',
                'Password mismatch':'Password mismatch',
                'Username':'Username',
                'DisplayName':'DisplayName',
                'Password':'Password',
                'Password Confirm':'Password Confirm',
                'Login':'Login'

            }
        },
        tr:{
            translations:{
                'Sign Up': 'Kayıt ol',
                'Password mismatch':'Aynı şifreyi giriniz',
                'Username':'Kullanıcı adı',
                'DisplayName':'Tercih Edilen İsim',
                'Password':'Şifre',
                'Password Confirm':'Şifre Tekrarı',
                'Login':"Giriş yap"
                
            }
        }
    },
    fallbackLng:'en',
    ns:['translations'],
    defaultNS:'translations',
    keySeparator:false,
    interpolation:{
        escapeValue:false,
        formatSeparator:','
    },
    react:{
        wait:true
    }
});

export default i18n; 