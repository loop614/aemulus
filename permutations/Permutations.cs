#!/usr/bin/env dotnet-script
#load "JohnsonTrotter.cs"
#load "Heaps.cs"

JohnsonTrotter jt = new();
int[][] res = jt.PermutationsJohnsonTrotter(1, 2, 3);
Console.WriteLine("JohnsonTrotter:");
foreach (int[] one in res)
{
    Console.WriteLine(string.Join(", ", one));
}

Heaps hs = new();
res = hs.PermutationsHeaps(1, 2, 3);
Console.WriteLine("Heaps:");
foreach (int[] one in res)
{
    Console.WriteLine(string.Join(", ", one));
}
