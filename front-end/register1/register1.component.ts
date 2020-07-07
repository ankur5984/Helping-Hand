import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../Model/User';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-register1',
  templateUrl: './register1.component.html',
  styleUrls: ['./register1.component.css']
})
export class Register1Component implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  user:any;
  constructor(private formBuilder: FormBuilder,private svc:AuthenticationService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      gender: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      add:['',[Validators.required]],
      occup:['',[Validators.required]],
      dob:['',[Validators.required]],
      contactNo:['',[Validators.required]]

  })
}


get f() { return this.registerForm.controls; }



onSubmit()
{
  this.submitted = true;

      
        if (this.registerForm.invalid) {
            return;
        }
       this.user={
         name:this.registerForm.value.firstName+""+this.registerForm.value.lastName,
         gender:this.registerForm.value.gender,
         dob:this.registerForm.value.dob,
         address:this.registerForm.value.add,
         occupation:this.registerForm.value.occup,
         mobile:this.registerForm.value.contactNo,
         email:this.registerForm.value.email,
         password:this.registerForm.value.password,
         age:null,
         regisration_date:null
       }
        console.log(this.user);


        alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
        this.svc.signUp(this.user).subscribe(
                  data=>
            {
             console.log(data);
             this.onReset();

            }


     );
}


onReset() {
  this.submitted = false;
  this.registerForm.reset();
}

}

