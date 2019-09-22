using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Program
{
    class ProgramTPC3
    {
        public static void Main()
        {


        }

        private static bool Foo(string msg)
        {
            if(msg.Length == 1)
                return true;
            
            if(msg[0] != msg[msg.Length-1])
                return false;

            if (msg.Length == 2)
                return true;

            return Foo(msg.Substring(1, msg.Length - 2));
        }
    }
}
