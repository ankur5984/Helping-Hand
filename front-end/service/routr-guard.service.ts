import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RoutrGuardService implements CanActivate {

  constructor(private auth:AuthenticationService,private route:Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {
    console.log("helloro");
   if(this.auth.isLogin())
   {
    return true;
  }
  else
  {
    this.route.navigate(['/']);
    return false;
  }
  }
}
