import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-view-component',
  templateUrl: './view-component.component.html',
  styleUrls: ['./view-component.component.css']
})
export class ViewComponentComponent implements OnInit {

  SubSystems: SubSystem[] = [];
  ActiveSubsystem: SubSystem;

  constructor(private httpClient: HttpClient) {
    var raceArray = [];
    this.httpClient.get('http://localhost:8080/rest1/subsystem/', {
      params: {
        /*        appid: 'id1234',
                cnt: '5'*/
      },
      observe: 'response'
    })
      .subscribe(resp => {
        console.log(resp.body);
        raceArray.push(resp.body);
        for (let obj of raceArray) {
          for (let i in obj) {
            console.log(obj[i].name);
            this.SubSystems.push(new SubSystem(obj[i].id, obj[i].name, obj[i].url, this.httpClient));
          }
        }
        this.ActiveSubsystem = this.SubSystems[0];
      });
  }

  ngOnInit() {}

  onChoice(subsys: string) {
    for(let i = 0; i < this.SubSystems.length; i++) {
      if(this.SubSystems[i].name == subsys) {
        this.ActiveSubsystem = this.SubSystems[i];
      }
      else {
      }
    }
  }
}

class SubSystem {

  id: number;
  name: string;
  url: string;
  command = "";
  command_array = [];
  resault: string;
  timestemp: string;

  constructor(id: number, name: string, url: string, private httpClient: HttpClient) {
    this.id = id;
    this.name = name;
    this.url = url;
  }

  setCommand() {
    console.log(this.name + " : " + this.command);
    this.command_array.push(this.command);

    this.httpClient.post('http://localhost:8080/rest1/subsystem?massage='+this.command+'&subsystem_name='+this.name, {
      params: {
/*        massage: this.command,
        subsystem_name: this.name*/
      },
      observe: 'response'
    }).subscribe();
  }

}
